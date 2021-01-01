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
package net.kyori.coffee.functional.action;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;

/**
 * An action that accepts one input argument and returns no result.
 *
 * @param <T1> the 1st argument type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Action1<T1> {
  /**
   * Performs this action on the given argument.
   *
   * @param t1 the 1st argument
   * @since 1.0.0
   */
  void accept(final T1 t1);

  /**
   * Gets an action that always does nothing.
   *
   * @param <T1> the 1st argument type
   * @return an action
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  static <T1> @NonNull Action1<T1> noop() {
    return (Action1<T1>) Actions.A1_NOOP;
  }

  /**
   * Provides {@code t1} to {@code a1}, and then returns {@code t1}.
   *
   * @param t1 the 1st argument
   * @param a1 the action
   * @param <T1> the 1st argument type
   * @return the 1st argument
   * @since 1.0.0
   */
  static <T1> @PolyNull T1 tap(final @PolyNull T1 t1, final @Nullable Action1<T1> a1) {
    if(a1 != null) a1.accept(t1);
    return t1;
  }
}
