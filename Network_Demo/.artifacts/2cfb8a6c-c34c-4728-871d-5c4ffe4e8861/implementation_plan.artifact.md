# Implementation Plan - Fix Post Item Colors

The posts in the `RecyclerView` are not displaying different colors because:
1.  The `MaterialCardView` in `post_item.xml` has a hardcoded `android:backgroundTint`, which overrides the background color set programmatically in `PostAdapter`.
2.  The color array is defined using the `<array>` tag but accessed via `getIntArray()`. While sometimes compatible, it's safer and more standard to use `<integer-array>` for an array of color integers.

## Proposed Changes

### [Resource Layer]

#### [MODIFY] [colors.xml](file:///D:/AndroidProjects/BT/ADR59_LeDieuHoa/Network_Demo/app/src/main/res/values/colors.xml)
- Change `<array>` to `<integer-array>` for `post_random_colors`.
- Ensure all color values include the alpha channel (e.g., `#FFF4AF9F`).

#### [MODIFY] [post_item.xml](file:///D:/AndroidProjects/BT/ADR59_LeDieuHoa/Network_Demo/app/src/main/res/layout/post_item.xml)
- Remove `android:backgroundTint="#ACEFE8"` from the `MaterialCardView` to allow `setCardBackgroundColor()` to take effect.

## Verification Plan

### Manual Verification
- Deploy the app to the device.
- Verify that each post card has a background color from the defined list (`#F4AF9F`, `#AFF0BA`, etc.) instead of the single constant color (`#ACEFE8`).
