package test.testactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Address;
import test.testactive.food.Food;
import test.testactive.repository.AddressRepository;
import test.testactive.repository.FoodRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private Address address;


    public void AddressSave(Address address){ //직접만든레포지
        addressRepository.save(address);
    }


    @Transactional(readOnly =true)
    public Address findOne(Long foodId) {
        return addressRepository.findOne(foodId);
    }
}
