package test.testactive.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Store;
import test.testactive.repository.StoreRepository;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StoreServiceTest {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    StoreService storeService;

        @Test
        public void  가게정보() throws Exception{
            //given

            Store store = new Store();
//
//            Store.


            //when

            //then


            }
}
