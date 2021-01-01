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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.PolyNull;

/**
 * A function that accepts ten arguments and produces a result.
 *
 * @param <T1> the 1st argument type
 * @param <T2> the 2nd argument type
 * @param <T3> the 3rd argument type
 * @param <T4> the 4th argument type
 * @param <T5> the 5th argument type
 * @param <T6> the 6th argument type
 * @param <T7> the 7th argument type
 * @param <T8> the 8th argument type
 * @param <T9> the 9th argument type
 * @param <T10> the 10th argument type
 * @param <R> the result type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> extends Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Function1<T10, R>> {
  /**
   * Applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @param t7 the 7th argument
   * @param t8 the 8th argument
   * @param t9 the 9th argument
   * @param t10 the 10th argument
   * @return the result
   * @since 1.0.0
   */
  R apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final T8 t8, final T9 t9, final T10 t10);

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function9<T2, T3, T4, T5, T6, T7, T8, T9, T10, R> apply(final T1 t1) {
    return (t2, t3, t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
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
  default @NonNull Function8<T3, T4, T5, T6, T7, T8, T9, T10, R> apply(final T1 t1, final T2 t2) {
    return (t3, t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function7<T4, T5, T6, T7, T8, T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3) {
    return (t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function6<T5, T6, T7, T8, T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
    return (t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function5<T6, T7, T8, T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5) {
    return (t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function4<T7, T8, T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6) {
    return (t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @param t7 the 7th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function3<T8, T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7) {
    return (t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @param t7 the 7th argument
   * @param t8 the 8th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function2<T9, T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final T8 t8) {
    return (t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Partially applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @param t7 the 7th argument
   * @param t8 the 8th argument
   * @param t9 the 9th argument
   * @return the result
   * @since 1.0.0
   */
  @Override
  default @NonNull Function1<T10, R> apply(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final T8 t8, final T9 t9) {
    return t10 -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  /**
   * Gets a function that always returns {@code result}.
   *
   * @param <T1> the 1st argument type
   * @param <T2> the 2nd argument type
   * @param <T3> the 3rd argument type
   * @param <T4> the 4th argument type
   * @param <T5> the 5th argument type
   * @param <T6> the 6th argument type
   * @param <T7> the 7th argument type
   * @param <T8> the 8th argument type
   * @param <T9> the 9th argument type
   * @param <T10> the 10th argument type
   * @param <R> the result type
   * @return a function
   * @since 1.0.0
   */
  static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> @NonNull Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, @PolyNull R> constantly(final @PolyNull R result) {
    return (t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> result;
  }
}
