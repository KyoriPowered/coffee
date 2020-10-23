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
package net.kyori.coffee.function;

final class Memoize {
  private Memoize() {
  }

  static <R> Function0<R> fn0(final Function0<R> fn0) {
    return new F0<>(fn0);
  }

  static class F0<R> implements Function0<R> {
    private final Function0<R> fn0;
    private transient volatile boolean memoized;
    private transient R result;

    F0(final Function0<R> fn0) {
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
