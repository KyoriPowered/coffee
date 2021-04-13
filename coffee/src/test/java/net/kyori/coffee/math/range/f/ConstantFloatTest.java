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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantFloatTest {
  @Test
  void testConstant() {
    final ConstantFloat r0 = ConstantFloat.constantly(2f);
    assertEquals(2f, r0.value());
  }

  @ParameterizedTest
  @ValueSource(floats = {1f, 3f})
  void testWithOutOfRangeValue(final float input) {
    final ConstantFloat r0 = ConstantFloat.constantly(2f);
    assertFalse(r0.test(input));
  }

  @Test
  void testWithInRangeValue() {
    final ConstantFloat r0 = ConstantFloat.constantly(2f);
    assertTrue(r0.test(2f));
  }

  @Test
  void testConstantRandom() {
    final ConstantFloat r0 = ConstantFloat.constantly(2f);
    final Random random = ThreadLocalRandom.current();
    for(int i = 0; i < 100; i++) {
      assertEquals(2f, r0.getFloat(random));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(ConstantFloat.constantly(2f))
      .addEqualityGroup(ConstantFloat.constantly(3f))
      .testEquals();
  }
}
