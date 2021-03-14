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

import java.util.Random;
import net.kyori.coffee.math.Mth;
import org.checkerframework.checker.nullness.qual.NonNull;

final class DoubleRangeImpl implements DoubleRange {
  private final double min;
  private final double max;

  DoubleRangeImpl(final double min, final double max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public double min() {
    return this.min;
  }

  @Override
  public double max() {
    return this.max;
  }

  @Override
  public boolean test(final double value) {
    return Mth.between(value, this.min, this.max);
  }

  @Override
  public double getDouble(final @NonNull Random random) {
    return Mth.random(random, this.min, this.max);
  }

  @Override
  public boolean equals(final Object other) {
    if(this == other) return true;
    if(other == null || this.getClass() != other.getClass()) return false;
    final DoubleRangeImpl that = (DoubleRangeImpl) other;
    return Mth.equals(this.min, that.min) && Mth.equals(this.max, that.max);
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(this.min);
    result = (31 * result) + Double.hashCode(this.max);
    return result;
  }
}