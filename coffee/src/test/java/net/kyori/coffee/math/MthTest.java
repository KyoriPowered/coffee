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
package net.kyori.coffee.math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MthTest {
  @Test
  void testClampd() {
    assertEquals(3d, Mth.clamp(3d, 0d, 5d));
    assertEquals(-3.1d, Mth.clamp(-7d, -3.1d, 5d));
    assertEquals(5d, Mth.clamp(7d, -3.1d, 5d));
    assertEquals(0.1d, Mth.clamp(-10d, 0.1d, 100d));
    assertEquals(100d, Mth.clamp(101d, 0.1d, 100d));
  }

  @Test
  void testClampf() {
    assertEquals(3f, Mth.clamp(3f, 0f, 5f));
    assertEquals(-3.1f, Mth.clamp(-7f, -3.1f, 5f));
    assertEquals(5f, Mth.clamp(7f, -3.1f, 5f));
    assertEquals(0.1f, Mth.clamp(-10f, 0.1f, 100f));
    assertEquals(100f, Mth.clamp(101f, 0.1f, 100f));
  }

  @Test
  void testClampi() {
    assertEquals(3, Mth.clamp(3, 0, 5));
    assertEquals(-3, Mth.clamp(-7, -3, 5));
    assertEquals(5, Mth.clamp(7, -3, 5));
    assertEquals(0, Mth.clamp(-10, 0, 100));
    assertEquals(100, Mth.clamp(101, 0, 100));
  }

  @Test
  void testClampl() {
    assertEquals(3L, Mth.clamp(3L, 0L, 5L));
    assertEquals(-3L, Mth.clamp(-7L, -3L, 5L));
    assertEquals(5L, Mth.clamp(7L, -3L, 5L));
    assertEquals(0L, Mth.clamp(-10L, 0L, 100L));
    assertEquals(100L, Mth.clamp(101L, 0L, 100L));
  }

  @Test
  void testBetweend() {
    assertFalse(Mth.between(0d, 0.5d, 3.5d));
    assertFalse(Mth.between(0d, 1d, 3d));
    assertTrue(Mth.between(0.5d, 0.5d, 3.5d));
    assertTrue(Mth.between(1d, 1d, 3d));
    assertTrue(Mth.between(2d, 1d, 3d));
    assertTrue(Mth.between(3d, 1d, 3d));
    assertTrue(Mth.between(3.5d, 0.5d, 3.5d));
    assertFalse(Mth.between(4d, 1d, 3d));
  }

  @Test
  void testBetweenf() {
    assertFalse(Mth.between(0f, 0.5f, 3.5f));
    assertFalse(Mth.between(0f, 1f, 3f));
    assertTrue(Mth.between(0.5f, 0.5f, 3.5f));
    assertTrue(Mth.between(1f, 1f, 3f));
    assertTrue(Mth.between(2f, 1f, 3f));
    assertTrue(Mth.between(3f, 1f, 3f));
    assertTrue(Mth.between(3.5f, 0.5f, 3.5f));
    assertFalse(Mth.between(4f, 1f, 3f));
  }

  @Test
  void testBetweeni() {
    assertFalse(Mth.between(0, 1, 3));
    assertTrue(Mth.between(1, 1, 3));
    assertTrue(Mth.between(2, 1, 3));
    assertTrue(Mth.between(3, 1, 3));
    assertFalse(Mth.between(4, 1, 3));
  }

  @Test
  void testBetweenl() {
    assertFalse(Mth.between(0L, 1L, 3L));
    assertTrue(Mth.between(1L, 1L, 3L));
    assertTrue(Mth.between(2L, 1L, 3L));
    assertTrue(Mth.between(3L, 1L, 3L));
    assertFalse(Mth.between(4L, 1L, 3L));
  }

  @Test
  void testRandomd() {
    final Random random = ThreadLocalRandom.current();
    final float min = 1.3f;
    final float max = 4.5f;
    for(int i = 0; i < 10; i++) {
      final float value = Mth.random(random, min, max);
      assertTrue(value >= min);
      assertTrue(value <= max);
    }
  }

  @Test
  void testRandomf() {
    final Random random = ThreadLocalRandom.current();
    final double min = 1.3d;
    final double max = 4.5d;
    for(int i = 0; i < 10; i++) {
      final double value = Mth.random(random, min, max);
      assertTrue(value >= min);
      assertTrue(value <= max);
    }
  }

  @Test
  void testRandomi() {
    final Random random = ThreadLocalRandom.current();
    final int min = 1;
    final int max = 4;
    for(int i = 0; i < 10; i++) {
      final int value = Mth.random(random, min, max);
      assertTrue(value >= min);
      assertTrue(value <= max);
    }
  }

  @Test
  void testSquared() {
    assertEquals(9d, Mth.square(3d));
    assertEquals(6.25d, Mth.square(2.5d));
  }

  @Test
  void testSquaref() {
    assertEquals(9f, Mth.square(3f));
    assertEquals(6.25f, Mth.square(2.5f));
  }

  @Test
  void testSquarei() {
    assertEquals(9, Mth.square(3));
  }
}
