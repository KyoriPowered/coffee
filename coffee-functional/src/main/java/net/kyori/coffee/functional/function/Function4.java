/*
 * This file is part of coffee, licensed under the MIT License.
 *
 * Copyright (c) 2020-2021 KyoriPowered
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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.PolyNull;

/**
 * A function that accepts four arguments and produces a result.
 *
 * @param <T1> the 1st argument type
 * @param <T2> the 2nd argument type
 * @param <T3> the 3rd argument type
 * @param <T4> the 4th argument type
 * @param <R> the result type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> extends Function3<T1, T2, T3, Function1<T4, R>> {
  /**
   * Applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @return the result
   * @since 1.0.0
   */
  R apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4);

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function3<T2, T3, T4, R> apply(final T1 t1) {
    return (t2, t3, t4) -> this.apply(t1, t2, t3, t4);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function2<T3, T4, R> apply(final T1 t1, final T2 t2) {
    return (t3, t4) -> this.apply(t1, t2, t3, t4);
  }

  /**
   * Partially applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function1<T4, R> apply(final T1 t1, final T2 t2, final T3 t3) {
    return t4 -> this.apply(t1, t2, t3, t4);
  }

  /**
   * Gets a function that always returns {@code result}.
   *
   * @param <T1> the 1st argument type
   * @param <T2> the 2nd argument type
   * @param <T3> the 3rd argument type
   * @param <T4> the 4th argument type
   * @param <R> the result type
   * @return a function
   * @since 1.0.0
   */
  static <T1, T2, T3, T4, R> @NonNull Function4<T1, T2, T3, T4, @PolyNull R> constantly(final @PolyNull R result) {
    return (t1, t2, t3, t4) -> result;
  }
}
