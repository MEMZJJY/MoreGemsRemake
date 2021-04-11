/*
 * Copyright (c) 2021 [MEMZJJY of copyright owner]
 * Licensed under the GNU General Public License v3.0
 *  (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.memzjjy.moregems.tag;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagContainer;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Optional;

public class MoregemsItemTags {
   public static final Tag<Item> BLUE_GEM = register("blue_gem");
   private static TagContainer<Item> container = new TagContainer((identifier) -> {
      return Optional.empty();
   }, "", false, "");
   private static int latestVersion;

   public static TagContainer<Item> getContainer() {
      return container;
   }

   public static void setContainer(TagContainer<Item> container) {
      MoregemsItemTags.container = container;
      ++latestVersion;
   }

   private static Tag<Item> register(String id) {
      return new MoregemsItemTags.CachingTag(new Identifier(id));
   }

   public static class CachingTag extends Tag<Item> {
      private int version = -1;
      private Tag<Item> delegate;

      public CachingTag(Identifier identifier) {
         super(identifier);
      }

      public boolean contains(Item item) {
         if (this.version != MoregemsItemTags.latestVersion) {
            this.delegate = MoregemsItemTags.container.getOrCreate(this.getId());
            this.version = MoregemsItemTags.latestVersion;
         }

         return this.delegate.contains(item);
      }

      public Collection<Item> values() {
         if (this.version != MoregemsItemTags.latestVersion) {
            this.delegate = MoregemsItemTags.container.getOrCreate(this.getId());
            this.version = MoregemsItemTags.latestVersion;
         }

         return this.delegate.values();
      }

      public Collection<Entry<Item>> entries() {
         if (this.version != MoregemsItemTags.latestVersion) {
            this.delegate = MoregemsItemTags.container.getOrCreate(this.getId());
            this.version = MoregemsItemTags.latestVersion;
         }

         return this.delegate.entries();
      }
   }
}
