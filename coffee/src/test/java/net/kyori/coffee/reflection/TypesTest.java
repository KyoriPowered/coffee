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
package net.kyori.coffee.reflection;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class TypesTest {
  @Test
  void testAncestorsSingleClass() {
    assertThat(Types.ancestors(Object.class))
      .containsExactly(Object.class)
      .inOrder();

    assertThat(Types.ancestors(A.class))
      .containsExactly(A.class, Object.class)
      .inOrder();
  }

  @Test
  void testAncestorsSingleInterface() {
    assertThat(Types.ancestors(B.class))
      .containsExactly(B.class)
      .inOrder();
  }

  @Test
  void testAncestorsMultipleInterfaces() {
    assertThat(Types.ancestors(E.class))
      .containsExactly(E.class, B.class, C.class)
      .inOrder();

    assertThat(Types.ancestors(F.class))
      .containsExactly(F.class, D.class, E.class, B.class, C.class)
      .inOrder();
  }

  @Test
  void testAncestorsMixedClassesAndInterfaces() {
    assertThat(Types.ancestors(G.class))
      .containsExactly(G.class, A.class, C.class, E.class, Object.class, B.class)
      .inOrder();

    assertThat(Types.ancestors(H.class))
      .containsExactly(H.class, G.class, D.class, B.class, F.class, A.class, C.class, E.class, Object.class)
      .inOrder();
  }

  class A {
  }

  interface B {
  }

  interface C {
  }

  interface D {
  }

  interface E extends B, C {
  }

  interface F extends D, E {
  }

  class G extends A implements C, E {
  }

  class H extends G implements D, B, F {
  }
}
