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
package net.kyori.coffee.math.range.i;

import java.util.function.IntPredicate;
import net.kyori.coffee.math.IntSource;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An {@code int} range.
 *
 * @since 1.0.0
 */
public interface IntRange extends IntPredicate, IntSource {
  /**
   * Creates an {@code int} range.
   *
   * @param min the minimum value, inclusive
   * @param max the maximum value, inclusive
   * @return an {@code int} range
   * @since 1.0.0
   */
  static @NonNull IntRange between(final int min, final int max) {
    return new IntRangeImpl(min, max);
  }

  /**
   * Gets the minimum value.
   *
   * @return the minimum value
   * @since 1.0.0
   */
  int min();

  /**
   * Gets the maximum value.
   *
   * @return the maximum value
   * @since 1.0.0
   */
  int max();
}
