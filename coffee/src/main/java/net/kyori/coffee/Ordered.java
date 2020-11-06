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
 * Something that is ordered.
 *
 * @param <T> the type
 * @see Comparables
 * @since 1.0.0
 */
public interface Ordered<T> extends Comparable<T> {
  /**
   * Checks if {@code this} is less than {@code that}.
   *
   * @param that the other object
   * @return {@code true} if {@code this} is less then {@code that}, {@code false} otherwise
   * @since 1.0.0
   */
  default boolean lt(final @NonNull T that) {
    return this.compareTo(that) < 0;
  }

  /**
   * Checks if {@code this} is less than or equal to {@code that}.
   *
   * @param that the other object
   * @return {@code true} if {@code this} is less than or equal to {@code that}, {@code false} otherwise
   * @since 1.0.0
   */
  default boolean lte(final @NonNull T that) {
    return this.compareTo(that) <= 0;
  }

  /**
   * Checks if {@code this} is greater than {@code that}.
   *
   * @param that the other object
   * @return {@code true} if {@code this} is greater than {@code that}, {@code false} otherwise
   * @since 1.0.0
   */
  default boolean gt(final @NonNull T that) {
    return this.compareTo(that) > 0;
  }

  /**
   * Checks if {@code this} is greater than or equal to {@code that}.
   *
   * @param that the other object
   * @return {@code true} if {@code this} is greater than or equal to {@code that}, {@code false} otherwise
   * @since 1.0.0
   */
  default boolean gte(final @NonNull T that) {
    return this.compareTo(that) >= 0;
  }
}
