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
package net.kyori.coffee.math.range.d;

import java.util.function.DoublePredicate;
import net.kyori.coffee.math.DoubleSource;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A constant {@code double} source.
 *
 * @since 1.0.0
 */
public interface ConstantDouble extends DoublePredicate, DoubleSource {
  /**
   * Creates a constant {@code double} source.
   *
   * @param value the value
   * @return a constant {@code double} source
   * @since 1.0.0
   */
  static @NonNull ConstantDouble constantly(final double value) {
    return new ConstantDoubleImpl(value);
  }

  /**
   * Gets the value.
   *
   * @return the value
   * @since 1.0.0
   */
  double value();
}
