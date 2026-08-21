# Fix Posts Not Appearing on Screen

The investigation revealed that the `PostAdapter` is hardcoded to return `0` items, and it doesn't notify the `RecyclerView` when new data is set.

## Proposed Changes

### [Adapter Component]

#### [MODIFY] [PostAdapter.java](file:///D:/AndroidProjects/BT/ADR59_LeDieuHoa/Network_Demo/app/src/main/java/vn/devpro/network_demo/PostAdapter.java)
- Initialize `posts` list to avoid potential `NullPointerException`.
- Update `setPosts` method to call `notifyDataSetChanged()`.
- Fix `getItemCount` to return `posts.size()`.

### [Model Component]

#### [MODIFY] [Post.java](file:///D:/AndroidProjects/BT/ADR59_LeDieuHoa/Network_Demo/app/src/main/java/vn/devpro/network_demo/model/Post.java)
- Change `userId` and `id` types from `String` to `int` to match the JSONPlaceholder API specification.

## Verification Plan

### Manual Verification
- Deploy the app to a device/emulator.
- Observe if the list of posts is fetched from `https://jsonplaceholder.typicode.com/posts` and displayed in the `RecyclerView`.
- Verify that titles and bodies are correctly mapped.
