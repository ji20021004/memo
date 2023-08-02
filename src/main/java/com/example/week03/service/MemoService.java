package com.example.week03.service;

import com.example.week03.domain.Memo;
import com.example.week03.domain.MemoRepository;
import com.example.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("아이디가 존재하지 않음")
    );
        memo.update(requestDto);
        return memo.getId();
    }

}
