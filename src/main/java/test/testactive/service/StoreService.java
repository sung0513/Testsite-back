package test.testactive.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.StoreRepository;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    /**
        store정보를 가져오는 메서드 작성
     */

    @Transactional
    public Long storeInfo(Long storeId,String name, int tel, Address address) {

        Store store = storeRepository.findOne(storeId);

        //이것을 storeRepository에서 받아와 주문을 저장한다.
        storeRepository.save(store);

        //그래서 주문의 id를 가져와 반환한다. 각각의 정보를 다 담아서
        return  store.getId();

    }

}
