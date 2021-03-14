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

import static net.kyori.test.Testing.assertNoneMatchf;
import static net.kyori.test.Testing.assetAllMatchf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FloatRangeTest {
  @Test
  void testBetween() {
    final FloatRange r0 = FloatRange.between(2.1f, 4.1f);
    assertEquals(2.1f, r0.min());
    assertEquals(4.1f, r0.max());
    assertNoneMatchf(r0, 1f, 2f, 4.2f, 5f);
    assetAllMatchf(r0, 2.2f, 3f, 4.1f);
  }

  @Test
  void testBetweenRandom() {
    final FloatRange r0 = FloatRange.between(1.2f, 9.3f);
    final Random random = ThreadLocalRandom.current();
    for(int i = 0; i < 100; i++) {
      assertTrue(Mth.between(r0.getFloat(random), 1.2f, 9.3f));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(
        FloatRange.between(0f, 10f),
        FloatRange.between(0f, 10f)
      )
      .testEquals();
  }
}
