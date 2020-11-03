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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.PolyNull;

/**
 * A function that accepts zero arguments and produces a result.
 *
 * @param <R> the result type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function0<R> {
  /**
   * Applies this function.
   *
   * @return the result
   * @since 1.0.0
   */
  R apply();

  /**
   * Gets a function which caches the result retrieved during the first call to {@link #apply()}
   * and returns the cached result on subsequent calls to {@link #apply()}.
   *
   * @return a memoized function
   * @since 1.0.0
   */
  default @NonNull Function0<R> memoize() {
    return Functions.memoizeF0(this);
  }

  /**
   * Gets a function that always returns {@code result}.
   *
   * @param <R> the result type
   * @return a function
   * @since 1.0.0
   */
  static <R> @NonNull Function0<@PolyNull R> constantly(final @PolyNull R result) {
    return () -> result;
  }
}
