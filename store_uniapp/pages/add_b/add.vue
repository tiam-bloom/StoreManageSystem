<template>
	<view>
		<form @submit="add">
			<input type="text" name="id" placeholder="请输入商品编号" />
			<input type="text" name="name" placeholder="请输入商品名" />
			<input type="text" name="cname" placeholder="请输入客户姓名" />
			<input type="number" name="amountb" placeholder="请输入商品数量" />
			<input type="text" name="time" placeholder="请输入下单时间" />
			<input type="number" name="price" placeholder="请输入订单金额" />
			<button type="primary" form-type="submit">确定添加</button>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {
			add: function(e) {
				uni.request({
					url: 'http://localhost:8080/addBill',
					method: 'POST',
					header: {
						'Content-Type': 'application/json'
					},
					data: {
						id: e.detail.value.id,
						name: e.detail.value.name,
						cname: e.detail.value.cname,
						amountb: e.detail.value.amountb,
						time: e.detail.value.time,
						price: e.detail.value.price
					},
					success: (res) => {
						console.log(res.data); //返回成功的状态									
						console.log(e.detail.value); //获取到表单填入的数据						
						uni.navigateBack({
							delta: 1
						});
						
					}
				});			
			},
			



		}
	}
</script>

<style>
	input{
		margin: 20px 10px;
	}
</style>
