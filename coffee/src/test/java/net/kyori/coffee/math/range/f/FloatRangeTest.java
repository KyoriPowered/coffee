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
package net.kyori.coffee.math.range.f;

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

class FloatRangeTest {
  @Test
  void testRange() {
    final FloatRange r0 = FloatRange.between(2.1f, 4.1f);
    assertEquals(2.1f, r0.min());
    assertEquals(4.1f, r0.max());
  }

  @ParameterizedTest
  @ValueSource(floats = {1f, 2f, 4.2f, 5f})
  void testWithOutOfRangeValue(final float input) {
    final FloatRange r0 = FloatRange.between(2.1f, 4.1f);
    assertFalse(r0.test(input));
  }

  @ParameterizedTest
  @ValueSource(floats = {2.2f, 3f, 4.1f})
  void testWithInRangeValue(final float input) {
    final FloatRange r0 = FloatRange.between(2.1f, 4.1f);
    assertTrue(r0.test(input));
  }

  @Test
  void testRandom() {
    final FloatRange r0 = FloatRange.between(1.2f, 9.3f);
    final Random random = ThreadLocalRandom.current();
    for(int i = 0; i < 100; i++) {
      assertTrue(Mth.between(r0.getFloat(random), 1.2f, 9.3f));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(FloatRange.between(0f, 5f))
      .addEqualityGroup(FloatRange.between(5f, 10f))
      .testEquals();
  }
}
