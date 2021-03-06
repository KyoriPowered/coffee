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
package net.kyori.coffee.functional.predicate;

import net.kyori.coffee.functional.function.Function1;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A predicate ({@code boolean}-valued function) of one argument.
 *
 * @param <T1> the 1st argument type
 * @since 1.0.0
 */
public interface Predicate1<T1> extends Function1<T1, Boolean> {
  /**
   * Evaluates this predicate on the given argument.
   *
   * @param t1 the 1st argument
   * @return {@code true} if the input argument matches the predicate, otherwise {@code false}
   * @since 1.0.0
   */
  boolean test(final T1 t1);

  @Override // to satisfy Function1
  default Boolean apply(final T1 t1) {
    return this.test(t1);
  }

  /**
   * Gets a predicate that always returns {@code result}.
   *
   * @param <T1> the 1st argument type
   * @return a predicate that always returns {@code result}
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  static <T1> @NonNull Predicate1<T1> constantly(final boolean result) {
    return result
      ? (Predicate1<T1>) Predicates.P1_TRUE
      : (Predicate1<T1>) Predicates.P1_FALSE;
  }
}
