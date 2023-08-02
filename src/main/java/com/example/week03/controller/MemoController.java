package com.example.week03.controller;

import com.example.week03.domain.Memo;
import com.example.week03.domain.MemoRepository;
import com.example.week03.domain.MemoRequestDto;
import com.example.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){ //생성자로 입력
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        LocalDateTime start = LocalDateTime.now(ZoneId.of("Asia/Seoul")).minusDays(1);
        LocalDateTime end = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id, requestDto);
        return id;
    }

}
