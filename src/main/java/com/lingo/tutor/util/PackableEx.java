package com.lingo.tutor.util;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
