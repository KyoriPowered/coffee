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
package net.kyori.coffee.functional.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Function1Test {
  @Test
  void testAp0() {
    final Function1<String, String> fn1 = Function1.identity();
    final Function0<String> fn0 = fn1.ap("kittens");
    assertEquals("kittens", fn0.apply());
  }

  @Test
  void testConstantly() {
    final Function1<Object, String> fn3 = Function1.constantly("strawberries");
    assertEquals("strawberries", fn3.apply("a"));
  }

  @Test
  void testMap() {
    assertEquals("strawberries", Function1.map("strawberries", Function1.identity()));
    assertEquals("strawberries!", Function1.map("strawberries", ab -> ab + "!"));
  }
}
