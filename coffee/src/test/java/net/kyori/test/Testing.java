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
package net.kyori.test;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import net.kyori.coffee.functional.predicate.number.Predicate1f;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class Testing {
  private Testing() {
  }

  @SuppressWarnings("SpellCheckingInspection") // "d" at end is intentional
  public static void assetAllMatchd(final DoublePredicate predicate, final double... values) {
    for(int i = 0; i < values.length; i++) {
      assertTrue(predicate.test(values[i]), "at index " + i);
    }
  }

  @SuppressWarnings("SpellCheckingInspection") // "d" at end is intentional
  public static void assertNoneMatchd(final DoublePredicate predicate, final double... values) {
    for(int i = 0; i < values.length; i++) {
      assertFalse(predicate.test(values[i]), "at index " + i);
    }
  }

  @SuppressWarnings("SpellCheckingInspection") // "f" at end is intentional
  public static void assetAllMatchf(final Predicate1f predicate, final float... values) {
    for(int i = 0; i < values.length; i++) {
      assertTrue(predicate.test(values[i]), "at index " + i);
    }
  }

  @SuppressWarnings("SpellCheckingInspection") // "f" at end is intentional
  public static void assertNoneMatchf(final Predicate1f predicate, final float... values) {
    for(int i = 0; i < values.length; i++) {
      assertFalse(predicate.test(values[i]), "at index " + i);
    }
  }

  @SuppressWarnings("SpellCheckingInspection") // "i" at end is intentional
  public static void assetAllMatchi(final IntPredicate predicate, final int... values) {
    for(int i = 0; i < values.length; i++) {
      assertTrue(predicate.test(values[i]), "at index " + i);
    }
  }

  @SuppressWarnings("SpellCheckingInspection") // "i" at end is intentional
  public static void assertNoneMatchi(final IntPredicate predicate, final int... values) {
    for(int i = 0; i < values.length; i++) {
      assertFalse(predicate.test(values[i]), "at index " + i);
    }
  }
}
