package com.bank.util;


import com.bank.util.Collection;

public interface List<T> extends Collection<T> {
    T get(int index);
}
