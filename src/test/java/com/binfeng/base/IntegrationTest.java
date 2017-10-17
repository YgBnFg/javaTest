package com.binfeng.base;

import com.binfeng.App;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bfyang on 2017/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
public class IntegrationTest {

    @LocalServerPort
    int serverPort;

    @Before
    public void baseSetUp() {
        RestAssured.port = serverPort;
    }
}
