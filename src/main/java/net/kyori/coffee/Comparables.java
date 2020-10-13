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
package net.kyori.coffee;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Things for working with {@link Comparable}s.
 *
 * @since 1.0.0
 */
public final class Comparables {
  private Comparables() {
  }

  /**
   * Checks if {@code left} is less than {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is less than {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean lt(final @NonNull C left, final @NonNull C right) {
    return left.compareTo(right) < 0;
  }

  /**
   * Checks if {@code left} is less than or equal to {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is less than or equal to {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean lte(final @NonNull C left, final @NonNull C right) {
    return left.compareTo(right) <= 0;
  }

  /**
   * Checks if {@code left} is greater than {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is greater than {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean gt(final @NonNull C left, final @NonNull C right) {
    return left.compareTo(right) > 0;
  }

  /**
   * Checks if {@code left} is greater than or equal to {@code right}.
   *
   * @param left the left object
   * @param right the right object
   * @param <C> the object type
   * @return {@code true} if {@code left} is greater than or equal to {@code right}, {@code false} otherwise
   * @since 1.0.0
   */
  public static <C extends Comparable<C>> boolean gte(final @NonNull C left, final @NonNull C right) {
    return left.compareTo(right) >= 0;
  }
}
