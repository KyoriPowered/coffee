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

/**
 * A function that accepts one argument and produces a result.
 *
 * @param <T1> the first argument type
 * @param <R> the result type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function1<T1, R> {
  /**
   * Applies this function to the given argument.
   *
   * @param t1 the first argument
   * @return the result
   * @since 1.0.0
   */
  R apply(final T1 t1);

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the first argument
   * @return a 0-argument function
   * @since 1.0.0
   */
  default @NonNull Function0<R> ap(final T1 t1) {
    return () -> this.apply(t1);
  }

  /**
   * Gets a function that always returns the input.
   *
   * @param <T1> the first argument type
   * @return an identity function
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  static <T1> @NonNull Function1<T1, T1> identity() {
    return (Function1<T1, T1>) Functions.F1_IDENTITY;
  }

  /**
   * Maps {@code t1} using {@code function}, and then returns the result.
   *
   * @param t1 the first argument
   * @param function the function
   * @param <T1> the first argument type
   * @param <R> the result type
   * @return the result of mapping {@code t1} using {@code function}
   * @since 1.0.0
   */
  static <T1, R> R map(final T1 t1, final @NonNull Function1<T1, R> function) {
    return function.apply(t1);
  }
}
