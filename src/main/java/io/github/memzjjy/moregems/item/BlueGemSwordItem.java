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

package io.github.memzjjy.moregems.item;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class BlueGemSwordItem extends SwordItem {
    public BlueGemSwordItem(Item.Settings settings) {
        super(MoregemsToolMaterials.BLUE_GEM, 5, 0.01F, settings);
    }
}
