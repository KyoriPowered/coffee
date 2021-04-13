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

import com.google.common.testing.EqualsTester;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.kyori.coffee.math.Mth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntRangeTest {
  @Test
  void testRange() {
    final IntRange r0 = IntRange.between(2, 4);
    assertEquals(2, r0.min());
    assertEquals(4, r0.max());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 5})
  void testWithOutOfRangeValue(final int input) {
    final IntRange r0 = IntRange.between(2, 4);
    assertFalse(r0.test(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 3, 4})
  void testWithInRangeValue(final int input) {
    final IntRange r0 = IntRange.between(2, 4);
    assertTrue(r0.test(input));
  }

  @Test
  void testRandom() {
    final IntRange r0 = IntRange.between(1, 9);
    final Random random = ThreadLocalRandom.current();
    for(int i = 0; i < 100; i++) {
      assertTrue(Mth.between(r0.getInt(random), 1, 9));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(IntRange.between(0, 5))
      .addEqualityGroup(IntRange.between(5, 10))
      .testEquals();
  }
}
