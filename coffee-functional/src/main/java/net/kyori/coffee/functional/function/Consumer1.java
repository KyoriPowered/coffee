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

import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;

/**
 * An operation that accepts a single input argument and returns no result.
 *
 * @param <T1> the first argument type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Consumer1<T1> {
  /**
   * Performs this operation on the given argument.
   *
   * @param t1 the first argument
   * @since 1.0.0
   */
  void accept(final T1 t1);

  /**
   * Gets a consumer that always does nothing.
   *
   * @param <T1> the first argument type
   * @return a consumer
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  static <T1> @NonNull Consumer1<T1> consume() {
    return (Consumer1<T1>) Functions.C1_CONSUME;
  }

  /**
   * Provides {@code t1} to {@code consumer}, and then returns {@code t1}.
   *
   * @param t1 the first argument
   * @param c1 the consumer
   * @param <T1> the first argument type
   * @return the first argument
   * @since 1.0.0
   */
  static <T1> @PolyNull T1 tap(final @PolyNull T1 t1, final @Nullable Consumer1<T1> c1) {
    if(c1 != null) c1.accept(t1);
    return t1;
  }

  /**
   * Converts a {@link Consumer1} into a {@link Consumer}.
   *
   * @param c1 the consumer
   * @param <T1> the first argument type
   * @return a java consumer
   * @since 1.0.0
   */
  static <T1> @NonNull Consumer<T1> java(final @NonNull Consumer1<T1> c1) {
    return c1::accept;
  }
}
