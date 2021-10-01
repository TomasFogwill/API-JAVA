package com.fogwill.DisneyWorld.webtesting;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.controllers.CharacterController;
import com.fogwill.DisneyWorld.security.MainSecurity;
import com.fogwill.DisneyWorld.services.CharacterService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CharacterController.class)
public class CharacterControllerTest{

    @Autowired 
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @MockBean
    private MainSecurity mainSecurity;

    @BeforeTestClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(@RestController CharacterController.class )
          .apply(springSecurity())
          .build();
    }


    @Test
    @WithMockUser(value = "spring")
    public void testGetCharacterModelsResponse() throws Exception{
        ArrayList<Object[]> listCharacter = new ArrayList<>();
        Object[] doris = {"imagen de doris","doris"};
        Object[] nemo = {"imagen de nemo","nemo"};
        listCharacter.add(doris);
        listCharacter.add(nemo);        
        Mockito.when(characterService.getCharacters()).thenReturn(listCharacter);
        String url = "/characters";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }


}


