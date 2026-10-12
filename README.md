# Cluttered (Unofficial Fabric Port)

![Cluttered logo](docs/cluttered_logo.png)

The GitHub repository for the Cluttered mod.

Cluttered is a furniture and decoration mod originally created by blake and YellowChuJelly. This repository is currently carrying an unofficial Fabric port of Cluttered 3.0.3 for Minecraft 26.3.

## Unofficial Fabric Port

This branch targets:

- Minecraft 26.3
- Fabric Loader 0.19.5 or newer
- Fabric API 0.160.5 or newer
- Java 25

The generated jar uses an `unofficial` suffix so it is easy to distinguish from official releases:

```text
build/libs/cluttered-3.0.3-26.3-0.3.0-fabric-unofficial.jar
```

This is not an official upstream release, and it is not a Forge jar.

## Included Port Work

- Ported Cluttered 3.0.3 from the Forge codebase to Fabric.
- Restored the official 3.0.3 models, blockstates, textures, item definitions, language entries, paintings, recipes, loot tables, and tags.
- Added Fabric registration for blocks, items, creative tabs, entities, block entities, render layers, composting, flammables, burn times, stripping, painting variants, and client renderers.
- Fixed multiple Fabric gameplay issues found during in-game testing, including storage block entities, record players, multiblock beds, and chair seating orientation.
- Added recipe-book unlock notifications so new recipes appear when the player obtains relevant ingredients.
- Added survival recipe fixes for Fabric tag and item name changes.
- Added in-game light emission to decorative objects that should visibly glow, including lamps, pearls, glow-themed objects, and deep chalcedony star variants.
- Restored the old `glow_flower`/flower lamp content from an older Cluttered build.
- Added small single-flavor jam jars while keeping the original larger jam jar blocks.
- Added glass-like block sounds for jam jars.
- Added stonecutter recipe coverage for decorative material families.

## Spanish Support

This port includes Spanish item and block names, with `es_cl` as the main reviewed translation.

Additional Spanish locale files are currently copied from the Chilean Spanish translation as placeholders:

- `es_ar`
- `es_ec`
- `es_es`
- `es_mx`
- `es_uy`
- `es_ve`

Translation follow-up notes are tracked in:

- `docs/traducciones_todo.md`

## Recipe Documentation

The in-game recipe book should show recipes once they are unlocked normally. For manual testing, this repo also includes Spanish recipe references:

- `docs/recetas_es_CL.md`
- `docs/cortapiedras_es_CL.md`

During local testing, a diagnostic gallery datapack can be generated under `build/datapacks` to place Cluttered blocks for broad render and placement checks.

## Building

Build the mod with:

```sh
sh ./gradlew build
```

The jar will be created in:

```text
build/libs/
```

## Testing Notes

This branch has been built and launch-tested against Minecraft 26.3 with Fabric Loader 0.19.5 and Fabric API 0.160.5+26.3. Both a dedicated server and the client reach a fully loaded state. The generated recipes, advancements, loot tables, and custom tree features have been migrated to the 26.3 data formats.

Shader packs are not specially integrated. Blocks that emit light use vanilla Minecraft light emission, which most shader packs can read normally, but emissive visuals still depend on the shader/resource-pack setup.

## Distribution Notes

If you share this build, label it clearly as an unofficial Fabric port for Minecraft 26.3 and include or link to the matching source code for this branch.

The project declares GNU GPL 3.0 licensing. See [LICENSE](LICENSE).

## Issues and Contributions

Players and modpack makers are welcome to open issues for bugs, crashes, missing translations, recipe problems, rendering issues, or other possible problems found in this unofficial port.

Pull requests are also welcome, but changes will be reviewed before they are merged.

## AI Transparency

This unofficial port was made possible with help from OpenAI Codex, an AI coding assistant, alongside human testing, review, debugging, and release work.

The original Cluttered authors gave permission for this unofficial port to be published. That permission should not be understood as an endorsement of AI tools or AI-assisted creative workflows. In particular, the original artists have made clear that they do not endorse the use of AI as artists.

This note is included so players, pack makers, and contributors can understand the context of this port and decide for themselves whether they want to use or support it.

## Credits

Cluttered was originally created by blake and YellowChuJelly. Huge thanks to the original creators and contributors for the mod, its art direction, assets, models, textures, and the work that made this unofficial port possible.

This repository is an unofficial compatibility port. All original Cluttered rights, authorship, branding, and licensing remain with their respective owners.

Logo/banner image from the official [Cluttered Modrinth page](https://modrinth.com/mod/cluttered).

The original README credited Kaupenjoe and McJty for modding tutorials used while learning and building Cluttered.
