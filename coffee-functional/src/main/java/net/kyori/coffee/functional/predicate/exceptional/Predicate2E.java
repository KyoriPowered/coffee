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
package net.kyori.coffee.functional.predicate.exceptional;

import net.kyori.coffee.functional.function.exceptional.Function2E;

/**
 * A predicate ({@code boolean}-valued function) of two arguments, potentially throwing an exception.
 *
 * @param <T1> the 1st argument type
 * @param <T2> the 2nd argument type
 * @param <E> the potential exception type
 * @since 1.0.0
 */
public interface Predicate2E<T1, T2, E extends Throwable> extends Function2E<T1, T2, Boolean, E> {
  /**
   * Evaluates this predicate on the given argument.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @return {@code true} if the input argument matches the predicate, otherwise {@code false}
   * @throws E potential exception
   * @since 1.0.0
   */
  boolean test(final T1 t1, final T2 t2) throws E;

  // to satisfy Function2E
  @Override
  default Boolean apply(final T1 t1, final T2 t2) throws E {
    return this.test(t1, t2);
  }
}
