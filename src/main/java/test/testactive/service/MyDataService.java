package test.testactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.repository.*;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MyDataService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;




}