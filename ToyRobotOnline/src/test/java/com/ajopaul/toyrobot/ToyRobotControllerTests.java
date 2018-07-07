package com.ajopaul.toyrobot;

import com.ajopaul.toyrobot.controllers.ToyRobotController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by ajopaul on 30/6/18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ToyRobotController.class)
public class ToyRobotControllerTests {

    @Autowired
    private ToyRobotController toyRobotController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(post("/reset"))
                .andExpect(status().isOk());
    }

    @Test
    public void testInitialReport() throws Exception {
        mockMvc.perform(get("/report"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.x", is(0)))
                .andExpect(jsonPath("$.y", is(0)))
                .andExpect(jsonPath("$.direction", is("NORTH")));
    }

    @Test
    public void testPlace() throws Exception {

        String placeCommand = "{" +
                "\"x\": 1," +
                "\"y\": 1," +
                "\"direction\":\"east\"" +
                "}";
        mockMvc.perform(post("/place")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(placeCommand)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.x", is(1)))
                .andExpect(jsonPath("$.y", is(1)))
                .andExpect(jsonPath("$.direction", is("EAST")));

    }

    @Test
    /**
     * One step move
     */
    public void testMove() throws Exception {

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.x", is(0)))
                .andExpect(jsonPath("$.y", is(1)))
                .andExpect(jsonPath("$.direction", is("NORTH")));
    }

    @Test
    public void testComplexMove1() throws Exception{
        String placeCommand = "{" +
                "\"x\": 4," +
                "\"y\": 4," +
                "\"direction\":\"east\"" +
                "}";
        mockMvc.perform(post("/place")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(placeCommand)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk());


        mockMvc.perform(post("/right"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/report"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.x", is(4)))
                .andExpect(jsonPath("$.y", is(3)))
                .andExpect(jsonPath("$.direction", is("SOUTH")));
    }

    @Test
    public void testComplexMove2() throws Exception {
        String placeCommand = "{" +
                "\"x\": 1," +
                "\"y\": 2," +
                "\"direction\":\"east\"" +
                "}";
        mockMvc.perform(post("/place")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(placeCommand)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/left"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/move"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/report"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.x", is(3)))
                .andExpect(jsonPath("$.y", is(3)))
                .andExpect(jsonPath("$.direction", is("NORTH")));
    }

}
