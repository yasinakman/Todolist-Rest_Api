package com.example.demo.TestController;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;

public class DateTest {


    public static void main(String[] args) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
//        TodoList list = new TodoList();
//        list.setListName("yasinin listesi");

//        TodoItem item = new TodoItem();
//        item.setItemName("todo item 2 ");
//        item.setListId(5);
//        item.setStatus(false);
//        item.setCreateDate(new Date());
//        item.setDeadline(new Date());

        /*Event event = new Event();
        event.setEvent("swimming");
        event.setUser(1L);
        String oldstring = "13-11-2018";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(oldstring);
        event.setCreateDate(date);
        RestTemplate restTemplate = new RestTemplate();
*/
        String path = "http://localhost:8080/addDependency";
        String path2 = "http://localhost:8080/addTodoList";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

//        RequestEntity requestEntity2 = new RequestEntity<>(list, headers, HttpMethod.POST, UriComponentsBuilder.fromHttpUrl(path2).build().toUri());
//        ResponseEntity<String> responseEntity2 = restTemplate.exchange(requestEntity2, String.class);
//        System.out.println(responseEntity2.getBody());

//
//        RequestEntity requestEntity = new RequestEntity<>(item, headers, HttpMethod.POST, UriComponentsBuilder.fromHttpUrl(path).build().toUri());
//        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//        System.out.println(responseEntity.getBody());


    }
}
