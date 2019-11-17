package com.buchhandlung.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.buchhandlung.demo.Buch.Buch;
import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class BuchControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void getBuchs() throws Exception {
        String uri = "/buchs";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Buch[] productlist = super.mapFromJson(content, Buch[].class);
        assertTrue(productlist.length >= 0);
    }

    @Test
    public void getBuch() throws Exception {
        String uri = "/buchs";
        Buch buch = new Buch();
        buch.setName("Ginger");
        String inputJson = super.mapToJson(buch);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Buch createdBuch  = super.mapFromJson(content, Buch.class);


        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/" + createdBuch.getId())
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


        content = mvcResult.getResponse().getContentAsString();
        Buch buchGetFromServer = super.mapFromJson(content, Buch.class);
        assertEquals(createdBuch.getId(), buchGetFromServer.getId());
        assertEquals(createdBuch.getName(), buchGetFromServer.getName());
    }

    @Test
    public void createBuch() throws Exception {
        String uri = "/buchs";
        Buch buch = new Buch();
        buch.setName("Ginger");
        String inputJson = super.mapToJson(buch);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Buch createdBuch  = super.mapFromJson(content, Buch.class);
        assertEquals(buch.getName(), createdBuch.getName());
    }

    @Test
    public void updateBuch() throws Exception {
        String uri = "/buchs";
        Buch buch = new Buch();
        buch.setName("Ginger");
        String inputJson = super.mapToJson(buch);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Buch createdBuch  = super.mapFromJson(content, Buch.class);


        buch = new Buch();
        buch.setName("Allee");
        inputJson = super.mapToJson(buch);
        mvcResult = mvc
                .perform(MockMvcRequestBuilders.put(uri + "/" + createdBuch.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        content = mvcResult.getResponse().getContentAsString();
        Buch updatedBuch  = super.mapFromJson(content, Buch.class);
        assertEquals(updatedBuch.getId(), createdBuch.getId());
        assertEquals(updatedBuch.getName(), buch.getName());
    }

    @Test
    public void deleteBuch() throws Exception {
        String uri = "/buchs";
        Buch buch = new Buch();
        buch.setName("Ginger");
        String inputJson = super.mapToJson(buch);
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Buch createdBuch  = super.mapFromJson(content, Buch.class);


        mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/" + createdBuch.getId())
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


        content = mvcResult.getResponse().getContentAsString();
        Buch deletedBuch = super.mapFromJson(content, Buch.class);
        assertEquals(createdBuch.getId(), deletedBuch.getId());
        assertEquals(createdBuch.getName(), deletedBuch.getName());
    }
}
