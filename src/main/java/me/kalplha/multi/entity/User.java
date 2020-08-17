package me.kalplha.multi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor

public final class User {
    private final String alias;

    // JSON (역) 직렬화를 위한 빈 생성장
    protected User()  {
        alias = null;
    }
}
