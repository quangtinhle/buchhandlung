package com.buchhandlung.demo;

import com.buchhandlung.demo.Buch.Buch;
import com.buchhandlung.demo.Buch.BuchController;
import com.buchhandlung.demo.Buch.BuchService;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import javax.swing.text.html.Option;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.*;
//import static org.mockito.ArgumentMatchers.contains;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(BuchController.class)
public class BuchControllerTestNew {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuchService buchService;

    @Test
    public void testGetBuch() throws Exception {
        Buch buch = new Buch(3, "lord of the ring", 32.54, "Alexander");

        when(this.buchService.getBuch(anyInt())).thenReturn(buch);

        this.mockMvc.perform(get("/buchs/3"))
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("lord of the ring")))
                .andExpect(jsonPath("$.preis", is(32.54)))
                .andExpect(jsonPath("$.author", is("Alexander")));
    }

    @Test
    public void testGetBuchs() throws Exception {
        Buch buch = new Buch(3, "lord of the ring", 32.54, "Alexander");

        when(this.buchService.getAllBuch()).thenReturn(
                List.of(
                        new Buch(3, "lord of the ring", 32.54, "Alexander"),
                        new Buch(5, "ring", 20.5, "David"),
                        new Buch(7, "big bang", 12.5, "Michael")
                )
        );

        this.mockMvc.perform(get("/buchs"))
                .andExpect(jsonPath("$.length()", is(3)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(5, 3, 7)))
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("lord of the ring", "ring", "big bang")))
                .andExpect(jsonPath("$[*].preis", containsInAnyOrder(32.54, 12.5, 20.5)))
                .andExpect(jsonPath("$[*].author", containsInAnyOrder("David", "Michael", "Alexander")));

    }
}
