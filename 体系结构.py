import tkinter as tk

# 主程序-子程序风格
class MainSubProgramStyle:
    def process(self, file_data):
        # 主程序-子程序风格的KWIC处理方法示例
        lines = file_data.split('\n')
        kwic_results = []
        for line in lines:
            words = line.split()
            for i in range(len(words)):
                rotated = ' '.join(words[i:] + words[:i])
                kwic_results.append(rotated)
        return '\n'.join(kwic_results)

# 面向对象风格
class ObjectOrientedStyle:
    def process(self, file_data):
        # 面向对象风格的KWIC处理方法示例
        lines = file_data.split('\n')
        kwic_results = []
        for line in lines:
            words = line.split()
            for i in range(len(words)):
                rotated = ' '.join(words[i:] + words[:i])
                kwic_results.append(rotated)
        return '\n'.join(kwic_results)

# 事件系统风格
class EventSystemStyle:
    def process(self, file_data):
        # 事件系统风格的KWIC处理方法示例
        lines = file_data.split('\n')
        kwic_results = []
        for line in lines:
            words = line.split()
            for i in range(len(words)):
                rotated = ' '.join(words[i:] + words[:i])
                kwic_results.append(rotated)
        return '\n'.join(kwic_results)

# 管道-过滤器风格
class PipeFilterStyle:
    def process(self, file_data):
        # 管道-过滤器风格的KWIC处理方法示例
        lines = file_data.split('\n')
        kwic_results = []
        for line in lines:
            words = line.split()
            for i in range(len(words)):
                rotated = ' '.join(words[i:] + words[:i])
                kwic_results.append(rotated)
        return '\n'.join(kwic_results)
# 创建主窗口和其他界面元素
root = tk.Tk()
root.title("经典软件体系结构教学软件")

principles = {
    1: "主程序-子程序风格的原理说明：\n主程序调用子程序完成具体任务，代码结构层次分明。",
    2: "面向对象风格的原理说明：\n通过对象的方式组织代码，将数据和操作封装在一起。",
    3: "事件系统风格的原理说明：\n基于事件和响应机制实现程序逻辑，提高灵活性和可扩展性。",
    4: "管道-过滤器风格的原理说明：\n将处理过程拆分为一系列独立的过滤器，通过管道连接。",
}

principle_text = tk.Text(root, height=10, width=50)
principle_text.pack()

principle_label = tk.Label(root, text="原理说明")
principle_label.pack()

# ... （其他界面元素的创建，包括原理说明文本框、处理文件的按钮、展示结果的文本框等）

# 处理文件的函数
def process_file():
    selected_style = style_var.get()
    file_data = input_text.get("1.0", tk.END)

    # 根据选择的风格进行文件处理
    if selected_style == 1:
        processed_data = MainSubProgramStyle().process(file_data)
    elif selected_style == 2:
        processed_data = ObjectOrientedStyle().process(file_data)
    elif selected_style == 3:
        processed_data = EventSystemStyle().process(file_data)
    elif selected_style == 4:
        processed_data = PipeFilterStyle().process(file_data)
    else:
        processed_data = ""

    output_text.delete("1.0", tk.END)
    output_text.insert("1.0", processed_data)


# 创建处理文件的按钮和展示处理结果的文本框
input_text = tk.Text(root, height=10, width=50)
input_text.pack()

process_btn = tk.Button(root, text="处理文件", command=process_file)
process_btn.pack()

output_text = tk.Text(root, height=10, width=50)
output_text.pack()

# 根据选择的风格显示对应的原理
def show_principle():
    selected_style = style_var.get()
    principle_text.delete("1.0", tk.END)
    principle_text.insert("1.0", principles.get(selected_style, "未找到对应的原理说明"))

# 创建选择体系结构风格的按钮
style_var = tk.IntVar()
style_var.set(1)

style_frame = tk.Frame(root)
style_frame.pack()

style_label = tk.Label(style_frame, text="选择体系结构风格:")
style_label.pack()

styles = [("主程序-子程序风格", 1), ("面向对象风格", 2), ("事件系统风格", 3), ("管道-过滤器风格", 4)]
for text, style in styles:
    style_btn = tk.Radiobutton(style_frame, text=text, variable=style_var, value=style, command=show_principle)
    style_btn.pack()

root.mainloop()
