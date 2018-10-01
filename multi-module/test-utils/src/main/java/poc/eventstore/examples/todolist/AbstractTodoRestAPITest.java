package poc.eventstore.examples.todolist;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import poc.eventstore.examples.todolist.model.GoalInfo;

import static poc.eventstore.examples.todolist.testutil.TestUtil.awaitNotFoundResponse;
import static poc.eventstore.examples.todolist.testutil.TestUtil.awaitSuccessfulRequest;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTodoRestAPITest {

    protected int port;

    private String commandsideBaseUrl(String path) {
        return "http://" + getCommandsideHost() + ":" + getCommandsidePort() + "/" + path;
    }

    private String querysideBaseUrl(String path) {
        return "http://" + getQuerysideHost() + ":" + getQuerysidePort() + "/" + path;
    }

    @Autowired
    private RestTemplate restTemplate;



    private TodoWithUrl awaitCreationInView(String todoId) {
        return awaitSuccessfulRequest(() -> getTodo(todoId));
    }

    private ResponseEntity<TodoWithUrl> createTodo(GoalInfo todoToSave) {
        ResponseEntity<TodoWithUrl> postResponse = restTemplate.postForEntity(commandsideBaseUrl("todos"), todoToSave, TodoWithUrl.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        return postResponse;
    }


    private ResponseEntity<TodoWithUrl> getTodo(String todoId) {
        return restTemplate.getForEntity(querysideBaseUrl("todos/" + todoId), TodoWithUrl.class);
    }

    private ResponseEntity<TodoWithUrl[]> getTodos() {
        return restTemplate.getForEntity(querysideBaseUrl("todos"), TodoWithUrl[].class);
    }

    private void assertTodoEquals(TodoWithUrl expectedTodo, TodoWithUrl todo) {
        Assert.assertEquals(expectedTodo.getTitle(), todo.getTitle());
        Assert.assertEquals(expectedTodo.getOrder(), todo.getOrder());
        Assert.assertEquals(expectedTodo.isCompleted(), todo.isCompleted());
    }

    private void assertTodoContains(TodoWithUrl expectedTodo, List<TodoWithUrl> todoList) {
        Assert.assertTrue(todoList.contains(expectedTodo));
    }

    private TodoWithUrl makeExpectedTodo(String todoId, GoalInfo todo) {
        TodoWithUrl todoWithUrl = new TodoWithUrl();
        //todoWithUrl.setCompleted(todo.isCompleted());
        //todoWithUrl.setOrder(todo.getOrder());
        //todoWithUrl.setTitle(todo.getTitle());
        //todoWithUrl.setId(todoId);
        todoWithUrl.setUrl(querysideBaseUrl("goals/" + todoId));
        return todoWithUrl;
    }

    private ResponseEntity<TodoWithUrl> updateTodo(String todoId, GoalInfo patch) {
        ResponseEntity<TodoWithUrl> patchResult = restTemplate.exchange(commandsideBaseUrl("todos/" + todoId), HttpMethod.PATCH, new HttpEntity<>(patch),
                TodoWithUrl.class);
        Assert.assertEquals(HttpStatus.OK, patchResult.getStatusCode());
        return patchResult;
    }

    private TodoWithUrl createAndWaitForView(GoalInfo todoToSave) {
        ResponseEntity<TodoWithUrl> postResponse = createTodo(todoToSave);

        String todoId = postResponse.getBody().getId();

        return awaitCreationInView(todoId);
    }

    @Test
    public void shouldSetCORSHeaders() {
        ResponseEntity<TodoWithUrl[]> responseEntity = getTodos();

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertFalse(responseEntity.getHeaders().get("Access-Control-Allow-Origin").isEmpty());
        Assert.assertEquals("*", responseEntity.getHeaders().get("Access-Control-Allow-Origin").get(0));
        Assert.assertFalse(responseEntity.getHeaders().get("Access-Control-Allow-Methods").isEmpty());
        Assert.assertEquals("POST, GET, OPTIONS, DELETE, PATCH", responseEntity.getHeaders().get("Access-Control-Allow-Methods").get(0));
        Assert.assertFalse(responseEntity.getHeaders().get("Access-Control-Max-Age").isEmpty());
        Assert.assertEquals("3600", responseEntity.getHeaders().get("Access-Control-Max-Age").get(0));
        Assert.assertFalse(responseEntity.getHeaders().get("Access-Control-Allow-Headers").isEmpty());
        Assert.assertEquals("x-requested-with, origin, content-type, accept", responseEntity.getHeaders().get("Access-Control-Allow-Headers").get(0));
    }

    @Test
    public void shouldShowAllTodos() {
        GoalInfo todoToSave = new GoalInfo("1st todo");

        assertTodoContains(createAndWaitForView(todoToSave),
                Arrays.asList(getTodos().getBody())
        );
    }

    @Test
    public void shouldDeleteAllTodos() throws InterruptedException {
        GoalInfo todoToSave = new GoalInfo("a todo");
        createAndWaitForView(todoToSave);

        restTemplate.delete(commandsideBaseUrl("todos"));

        awaitSuccessfulRequest(
                this::getTodos,
                re -> re.length == 0
        );

    }


    @Test
    public void shouldDeleteSingleTodo() throws InterruptedException {
        GoalInfo todoToSave = new GoalInfo("a todo");
        TodoWithUrl todo = createAndWaitForView(todoToSave);

        restTemplate.delete(commandsideBaseUrl("todos/" + todo.getId()));

        awaitNotFoundResponse(idx -> getTodo(todo.getId()));
    }

    @Test
    public void shouldCreateNewTodo() throws InterruptedException {
        GoalInfo todoToSave = new GoalInfo("walk the dog");
        TodoWithUrl todoView = createAndWaitForView(todoToSave);

        TodoWithUrl expectedTodo = makeExpectedTodo(todoView.getId(), todoToSave);

        assertTodoEquals(expectedTodo, todoView);
    }

    @Test
    public void shouldUpdateTodo() throws InterruptedException {

        GoalInfo todoToSave = new GoalInfo("todo 1");
        String todoId = createAndWaitForView(todoToSave).getId();

        GoalInfo todoWithChanges = new GoalInfo();
        //todoWithChanges.setTitle("todo 2");
        //todoWithChanges.setCompleted(true);
        //todoWithChanges.setOrder(42);

        ResponseEntity<TodoWithUrl> patchResult = updateTodo(todoId, todoWithChanges);

        TodoWithUrl expectedTodo = makeExpectedTodo(todoId, todoWithChanges);

        TodoWithUrl updatedTodo = patchResult.getBody();
        assertTodoEquals(expectedTodo, updatedTodo);

        /*TodoWithUrl updatedTodoInView = awaitSuccessfulRequest(
                () -> getTodo(todoId),
                re -> re.getTitle().equals(todoWithChanges.getTitle())
        );

        assertTodoEquals(expectedTodo, updatedTodoInView);
*/
    }


    protected abstract int getCommandsidePort();

    protected abstract String getCommandsideHost();

    protected abstract int getQuerysidePort();

    protected abstract String getQuerysideHost();
}

