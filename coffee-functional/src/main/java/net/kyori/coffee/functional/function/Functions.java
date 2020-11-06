/*
 * This file is part of coffee, licensed under the MIT License.
 *
 * Copyright (c) 2020 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.coffee.functional.function;

final class Functions {
  static final Consumer1<Object> C1_CONSUME = t1 -> {
  };
  static final Function1<Object, Object> F1_IDENTITY = t1 -> t1;
  static final Predicate1<Object> P1_FALSE = t1 -> false;
  static final Predicate1<Object> P1_TRUE = t1 -> true;

  private Functions() {
  }

  static <R> Function0<R> memoizeF0(final Function0<R> fn0) {
    if(fn0 instanceof MemoizeF0<?>) return fn0;
    return new MemoizeF0<>(fn0);
  }

  private static class MemoizeF0<R> implements Function0<R> {
    private final Function0<R> fn0;
    private volatile boolean memoized;
    private R result;

    MemoizeF0(final Function0<R> fn0) {
      this.fn0 = fn0;
    }

    @Override
    public R apply() {
      if(!this.memoized) {
        synchronized(this) {
          if(!this.memoized) {
            final R result = this.fn0.apply();
            this.result = result;
            this.memoized = true;
            return result;
          }
        }
      }
      return this.result;
    }
  }
}
