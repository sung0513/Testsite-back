package test.testactive.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.StoreRepository;


import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Long Storesave(Store store) { //직접만든레포지토리
        storeRepository.save(store);
        return store.getId();
    }

    /**
     * DB에서 store정보를 가져오는 메서드 작성
     */

    @Transactional
    public Long storeInfo(Long storeId, String name, int tel, Address address) {

        Store store = storeRepository.findOne(storeId);

        //이것을 storeRepository에서 받아와 주문을 저장한다.
        storeRepository.save(store);

        //그래서 주문의 id를 가져와 반환한다. 각각의 정보를 다 담아서
        return store.getId(); //스토어정보

    }

    /**
     웹에서 사용자가 입력한 정보를 보여주는 메서드 작성
     */


}
