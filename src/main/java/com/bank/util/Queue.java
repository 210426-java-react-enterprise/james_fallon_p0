package com.bank.util;

import com.bank.util.Collection;

public interface Queue <T> extends Collection<T> {
    T poll();
    T peek();
}
