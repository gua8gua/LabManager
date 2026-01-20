## 一、 实验案例对象模型 (Data Model)

在前后端传输中，一个完整的“实验案例”对象包含以下字段：

| **字段名**    | **类型**       | **说明**     |
| ------------- | -------------- | ------------ |
| `id`          | Integer/String | 案例唯一标识 |
| `name`        | String         | 实验名称     |
| `type`        | String         | 实验类型     |
| `content`     | String         | 实验内容     |
| `method`      | String         | 实验方法     |
| `requirement` | String         | 实验要求     |
| `result`      | String         | 实验结果     |
| `evaluation`  | String         | 实验评价     |
| `code`        | String         | 相关代码     |

------

## 二、 UI 动作与功能定义

### 2.1 列表管理页

- **UI 动作**：进入页面。
  - **动作说明**：触发“获取列表”接口。
- **UI 动作**：点击“搜索”按钮。
  - **动作说明**：根据输入的 `name` 或 `type` 进行模糊查询。
- **UI 动作**：点击“删除”。
  - **动作说明**：弹出确认框，确认后根据 `id` 调用“删除案例”接口。

### 2.2 新增/编辑弹窗

- **UI 动作**：点击“新增”按钮。
  - **动作说明**：打开空白表单。
- **UI 动作**：点击“编辑”按钮。
  - **动作说明**：调用“获取详情”接口回显数据，展示编辑表单。
- **UI 动作**：点击“提交”按钮。
  - **动作说明**：前端校验必填项，根据状态调用“新增”或“修改”接口。

------

## 三、接口规范 (API Endpoints)

### 3.0 通用报文规范

为了降低前后端联调成本，所有接口必须遵循以下格式：

- **请求头 (Headers):** * `Content-Type: application/json`

  - `Authorization: Bearer {token}` (若涉及权限校验)

- **通用请求格式:** 只有 `POST` 和 `PUT` 需发送 JSON Body。

- **通用响应格式:**

  JSON

  ```
  {
    "code": 200,          // 状态码：200-成功, 400-前端错, 500-服务器错
    "message": "操作描述", // 提示信息
    "data": null          // 具体的业务数据（对象或数组）
  }
  ```

------

### 3.1 获取实验案例列表 (Retrieve List)

用于首页或列表页展示，支持模糊搜索。

- **请求类型**: `GET`

- **路径**: `/api/v1/cases`

- **发送数据 (Query Params)**:

  - `name`: String (可选，用于按名称搜索)
  - `type`: String (可选，用于按类型筛选)

- **响应数据格式**:

  JSON

  ```
  {
    "code": 200,
    "message": "查询成功",
    "data": [
      {
        "id": 1,
        "name": "快速排序实验",
        "type": "算法",
        "content": "理解分治思想..."
      }
    ]
  }
  ```

### 3.2 获取单个案例详情 (Retrieve Detail)

用于查看详情页或进入编辑模式时的回显。

- **请求类型**: `GET`

- **路径**: `/api/v1/cases/{id}`

- **发送数据**: 路径参数 `id`

- **响应数据格式**:

  JSON

  ```
  {
    "code": 200,
    "message": "获取成功",
    "data": {
      "id": 1,
      "name": "快速排序实验",
      "type": "算法",
      "content": "详细内容...",
      "method": "递归法...",
      "requirement": "时间复杂度...",
      "result": "输出有序序列",
      "evaluation": "优秀",
      "code": "void quickSort()..."
    }
  }
  ```

### 3.3 创建新实验案例 (Create)

用于前端表单提交新案例。

- **请求类型**: `POST`

- **路径**: `/api/v1/cases`

- **发送数据 (JSON Body)**:

  JSON

  ```
  {
    "name": "新实验",
    "type": "基础",
    "content": "内容描述",
    "method": "方法步骤",
    "requirement": "实验要求",
    "result": "预期结果",
    "evaluation": "初步评价",
    "code": "print('hello')"
  }
  ```

- **响应数据格式**:

  JSON

  ```
  {
    "code": 200,
    "message": "创建成功",
    "data": { "id": 102 } // 返回新生成的ID
  }
  ```

### 3.4 修改现有案例 (Update)

用于保存编辑后的信息。

- **请求类型**: `PUT`

- **路径**: `/api/v1/cases/{id}`

- **发送数据 (JSON Body)**:

  JSON

  ```
  {
    "name": "修改后的实验名称",
    "type": "综合",
    "content": "更新后的内容...",
    "method": "更新后的方法...",
    "requirement": "...",
    "result": "...",
    "evaluation": "...",
    "code": "..."
  }
  ```

- **响应数据格式**:

  JSON

  ```
  {
    "code": 200,
    "message": "更新完成",
    "data": null
  }
  ```

### 3.5 删除案例 (Delete)

用于删除指定的实验案例。

- **请求类型**: `DELETE`

- **路径**: `/api/v1/cases/{id}`

- **发送数据**: 路径参数 `id`

- **响应数据格式**:

  JSON

  ```
  {
    "code": 200,
    "message": "删除成功",
    "data": null
  }
  ```