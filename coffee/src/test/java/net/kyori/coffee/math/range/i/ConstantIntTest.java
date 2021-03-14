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
import org.junit.jupiter.api.Test;

import static net.kyori.test.Testing.assertNoneMatchi;
import static net.kyori.test.Testing.assetAllMatchi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantIntTest {
  @Test
  void testConstant() {
    final ConstantInt r0 = ConstantInt.constantly(2);
    assertEquals(2, r0.value());
    assetAllMatchi(r0, 2);
    assertNoneMatchi(r0, 1, 3);
  }

  @Test
  void testConstantRandom() {
    final ConstantInt r0 = ConstantInt.constantly(2);
    final Random random = ThreadLocalRandom.current();
    for(int i = 0; i < 100; i++) {
      assertEquals(2, r0.getInt(random));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(
        ConstantInt.constantly(6),
        ConstantInt.constantly(6)
      )
      .testEquals();
  }
}
