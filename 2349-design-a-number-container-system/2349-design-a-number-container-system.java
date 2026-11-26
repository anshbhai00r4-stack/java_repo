class NumberContainers {

    HashMap<Integer, Integer> map;
    HashMap<Integer, PriorityQueue<Integer>> pq;

    public NumberContainers() {
        map = new HashMap<>();
        pq = new HashMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);

        pq.putIfAbsent(number, new PriorityQueue<>());
        pq.get(number).offer(index);
    }

    public int find(int number) {
        if (!pq.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> heap = pq.get(number);

        while (!heap.isEmpty() && map.get(heap.peek()) != number) {
            heap.poll();
        }

        return heap.isEmpty() ? -1 : heap.peek();
    }
}
