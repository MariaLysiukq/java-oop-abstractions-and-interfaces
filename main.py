class Node:
    def __init__(self, priority, task):
        self.priority = priority
        self.task = task
        
    def __repr__(self):
        return f"({self.priority}, '{self.task}')"

def bfs_to_array(graph, start):
    visited = set()
    queue = [start]
    result = []
    while queue:
        curr = queue.pop(0)
        if curr not in visited:
            visited.add(curr)
            result.append(curr)
            for neighbor in graph.get(curr, []):
                if neighbor not in visited:
                    queue.append(neighbor)
    return result

class MinHeap:
    def __init__(self):
        self.container = []

    def push(self, element):
        self.container.append(element)
        self._heapify_up(len(self.container) - 1)

    def pop(self):
        if not self.container: return None
        if len(self.container) == 1: return self.container.pop()
        
        min_elem = self.container[0]
        self.container[0] = self.container.pop()
        self._heapify_down(0)
        return min_elem

    def _heapify_up(self, index):
        if index <= 0: return
        parent = (index - 1) // 2
        # Підтримка однакових пріоритетів
        if self.container[parent].priority <= self.container[index].priority: return
        self._swap(parent, index)
        self._heapify_up(parent)

    def _heapify_down(self, index):
        smallest = index
        left = 2 * index + 1
        right = 2 * index + 2

        if left < len(self.container) and self.container[left].priority < self.container[smallest].priority:
            smallest = left
        if right < len(self.container) and self.container[right].priority < self.container[smallest].priority:
            smallest = right
        
        if smallest != index:
            self._swap(index, smallest)
            self._heapify_down(smallest)
            
    def _swap(self, i, j):
        self.container[i], self.container[j] = self.container[j], self.container[i]


# Створення тестового графа
n1 = Node(5, "Task A")
n2 = Node(1, "Task B")
n3 = Node(3, "Task C")
n4 = Node(1, "Task D (однаковий пріоритет)")
n5 = Node(4, "Task E")

graph = {
    n1: [n2, n3],
    n2: [n4],
    n3: [n5],
    n4: [],
    n5: []
}

# Тестування BFS
bfs_array = bfs_to_array(graph, n1)
print("Масив після BFS:", bfs_array)

# Тестування мін-купи
heap = MinHeap()
for node in bfs_array:
    heap.push(node)

popped_elements = []
while True:
    node = heap.pop()
    if not node:
        break
    popped_elements.append(node)

print("Порядок вилучення з купи:", popped_elements)